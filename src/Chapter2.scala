object Chapter2 {

  object Exercise2_3 {
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)
  }

  object Exercise2_4 {
    def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)
  }

  object Exercise2_5 {
    def compose[A,B,C](f: A => B, g: B => C): A => C = (a:A) => g(f(a))
  }
}