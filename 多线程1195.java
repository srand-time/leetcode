/*
编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：


	如果这个数字可以被 3 整除，输出 "fizz"。
	如果这个数字可以被 5 整除，输出 "buzz"。
	如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。


例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。

假设有这么一个类：

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}

请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：


	线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
	线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
	线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
	线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

法一：（CyclicBarrier）

class FizzBuzz {
    private int n;
    private CyclicBarrier bar=new CyclicBarrier (4);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=1;i<=n;i++)
        {
            if(i%5!=0&&i%3==0)
                printFizz.run(); 
            try   {bar.await();}
            catch (BrokenBarrierException e){e.printStackTrace();}
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++)
        {
            if(i%5==0&&i%3!=0)
                printBuzz.run();    
            try   {bar.await();}
            catch (BrokenBarrierException e){e.printStackTrace();}
        } 
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++)
        {
            if(i%3==0&&i%5==0)
                printFizzBuzz.run();    
            try   {bar.await();}
            catch (BrokenBarrierException e){e.printStackTrace();}
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++)
        {
            if(i%3!=0&&i%5!=0)
                printNumber.accept(i);    
            try   {bar.await();}
            catch (BrokenBarrierException e){e.printStackTrace();}
        }
    }
}



法二:	（信号量）
class FizzBuzz {
    private int n;
    private volatile boolean stop=false;
    private volatile int now=1;
    private Semaphore fi=new Semaphore(0);
    private Semaphore bu=new Semaphore(0);
    private Semaphore fibu=new Semaphore(0);
    private Semaphore num=new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            fi.acquire();
            if(now>n)
                break;    
            printFizz.run();
            num.release();
            now++;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            bu.acquire();
            if(now>n)
                break;
            printBuzz.run();
            num.release();
            now++;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            fibu.acquire();
            if(now>n)
                break;
            printFizzBuzz.run();
            num.release();
            now++;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true){
            num.acquire();
            if(now>n)
                break;
            //System.out.println(now);
            if(now%3!=0&&now%5!=0)
            {
                printNumber.accept(now);
                now++;
                num.release();
            }
            else if(now%3==0&&now%5==0)
                fibu.release();
            else if(now%3!=0&&now%5==0)
                bu.release();
            else
                fi.release();
        }
        fi.release();
        bu.release();
        fibu.release();
    }
}



