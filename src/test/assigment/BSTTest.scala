import com.bst.BST

object BSTTest {
def main(args:Array[String]) =
 {

   val bst = new BST[Int]
   bst.insert( 8)
   bst.insert( 2)
   bst.insert( 6)
   bst.insert( -3)
   bst.insert( 12)
   bst.insert( 5)


   val x  = bst.find(2)
   val v  = bst.find(-3)
   assert(x.get == 2)
   assert(v.get == -3)
 }
}
