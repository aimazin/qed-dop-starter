package qed.core

@main def runStarterKit(): Unit =
  println("Initializing QED-DOP Field...")

  val history = List(
    QED.Delta(10, 1L),
    QED.Delta(5, 2L),
    QED.Delta(-2, 3L)
  )

  // Resolving state via the Conservation Monoid
  val finalState = history.foldLeft(summon[QED.ConservationLaw[Int]].empty)(
    summon[QED.ConservationLaw[Int]].combine
  )

  println(s"Final Secure State: \\${finalState.value}")