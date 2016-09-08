import scala.annotation.tailrec

object Chapter2{

  object Exercise2_1{
    def fib(n:Int):Int = {
      @tailrec
      def fib_inter(i:Int, p:Int, c:Int):Int = {
        if(i < 1) 0
        else if(i == 1) p
        else if (i == 2) c
        else fib_inter(i-1,c, p+c)
      }

      fib_inter(n,0,1)
    }
  }

  object Exercise2_2 {
    def isSorted[A](array:Array[A], f:(A,A) => Boolean): Boolean = {
      val list = array.toList
      def isSorted(l:List[A]):Boolean = {
        l match {
          case Nil => true
          case _::Nil => true
          case a::b::c =>
            val r = f(a,b)
            if (r){
              r && isSorted(b::c)
            } else {
              false
            }
        }
      }

      isSorted(list)
    }
  }

  object Exercise2_3 {
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)
  }

  object Exercise2_4 {
    def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)
  }

  object Exercise2_5 {
    def compose[A,B,C](f: A => B, g: B => C): A => C = (a:A) => g(f(a))
  }

  def main(args:Array[String]): Unit ={
    assert(Exercise2_1.fib(0) == 0)
  }
}