package qed.core

import cats.kernel.Monoid

// The 'Field' infrastructure
object QED:
  opaque type VertexID = String
  opaque type Balanced[A] = A

  case class Delta[A](value: A, spin: Long)

  // A Conservation Law is a type-level proof of integrity
  trait ConservationLaw[A] extends Monoid[Delta[A]]:
    def empty: Delta[A]
    def combine(x: Delta[A], y: Delta[A]): Delta[A]

// Implementation for a secure counter
given IntConservationLaw: QED.ConservationLaw[Int] with
  def empty: QED.Delta[Int] = QED.Delta(0, 0L)
  def combine(x: QED.Delta[Int], y: QED.Delta[Int]): QED.Delta[Int] =
    if y.spin == x.spin + 1 then
      QED.Delta(x.value + y.value, y.spin)
    else
      throw new SecurityException("Incoherent History: Quantum Spin Mismatch")