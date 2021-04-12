package com.bst

class BST[V] (implicit ord:Ordering[V]) {

private sealed trait gTree[V]

private case object Leaf extends Tree[V]

private case class Branch[V](left: Tree[V], right: Tree[V],  v: V) extends Tree[V]
  private var root: Tree[V] = Leaf


  def insert[A]( v: V): Unit = {
    this.root = insert(root, v);
  }

  def find(v:V):Option[V] = {
    find(root,v)
  }
private def insert(t:Tree[V],value: V):Tree[V] = t match {

  case Leaf => Branch(Leaf,Leaf,value)
  case Branch(l,r,v)  if ord.equiv(value,v)
  => Branch(l,r,value)
  case Branch(l,r,v)  if ord.lt(value,v)
  => Branch(insert(l,value),r,v)
  case Branch(l,r,v)  if ord.gt(value,v)
  => Branch(l,insert(r,value),v)
}

@annotation.tailrec
private def find(t:Tree[V], value: V): Option[V] = t match {
  case Leaf => None
  case Branch(l,r,v) =>
    if (ord.equiv(value,v)) Some(v)
    else if(ord.lt(value,v)) find(l,value)
    else find(r,value)
}

/*
Would this class structure be different if you would have implemented them in a non-functional language like Java,
Python, Go or C? In what sense?
I don't think its going to be much different in another implementation
 */

}
