package graph;

public class ALGraph {
	
	static class VNode {
		int value;
		ENode first;
		
	}

	static class ENode {
		int value;
		ENode next;
	}
	
	static VNode[] list;
	static int Vnum, Enum;
	
	public static VNode firstNeighbor(VNode v) {
		for (VNode temp: list) {
			if (temp.value == v.first.value) return temp;
		}
		return null;
	}
	
	public static VNode nextNeighbor(VNode v, VNode pre) {
		ENode e = v.first;
		while (e.value != pre.value) {
			e = e.next;
		}
		e = e.next;
		for (VNode temp: list) {
			if (e.value == temp.value) return temp;
		}
		return null;
	}
	
	public static void bfs() {
		//使用队列
	}
	
}
