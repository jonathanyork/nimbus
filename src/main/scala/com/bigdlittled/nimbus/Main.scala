package com.bigdlittled.nimbus

import scalaz._

object Main extends App {

  val node = Node(1, "original", List.range(1,10).map(
        x => Node(10 + x, "original", List.range(1,10).map(
          x => Node(100 + x, "original", List.empty[Node])))))

  val name: Lens[Node, String] = Lens.lensu((u, newName) => u.copy(name = newName), _.name)
  val children: Lens[Node, List[Node]] = Lens.lensu((u, newList) => u.copy(children = newList), _.children)
  val child: Lens[Node, Node] = Lens.lensu(
    (u, newNode) => u.copy(children = 
      u.children.map(n => if (n.id == newNode.id) newNode else n)),
    u => u.children.filter(_.id == u.id).head // TODO Handle the not found case
  )

  println(node)

  println(name.set(node, "modified"))

  def modify(id: Int) = {
    def modify(id: Int, n: Node): Node = {
      if (n.id == id) name.set(n, "modified")
      n.children.map(modify(id, _))
      n
    }
    modify(id, node)
  }
  
  println(modify(102))

}

case class Node(id: Int, name: String, children: List[Node])
