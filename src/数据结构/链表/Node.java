package 数据结构.链表;

/**
 * java实现单向链表
 * @Title:Node
 * @Description:
 * @author sky
 * @date 2018年4月27日
 */
public class Node {

	//数据域 
	public int data;
	//指针域,指向头节点
	public static Node head = new Node();
	//指针域,指向下一个节点
	public Node next;
	
	public Node() {
		
	}
	
	public Node(int data) {
		this.data = data;
	}

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	/**
	 * 向链表中插入数据
	 * @method: addData 
	 * @param value 要添加的数据
	 * @return void
	 */
	public static void addData(int value) {
		//初始化要加入的节点
		Node node = new Node(value);
		//临时节点
		Node temp = head;
		//找到尾节点,遍历链表
		while(temp.next != null) {
			temp = temp.next;
		}
		//已经包括了头结点为Null的情况了
		temp.next = node;
	}
	
	/**
	 * 遍历链表
	 * @method: traverse 
	 * @param head 头结点 
	 * @return void
	 */
	public static void traverse(Node head) {
		//临时节点,从首节点开始
		Node temp = head.next;
		while (temp !=null ) {
			System.out.println("当前节点内容："+temp.data);
			temp = temp.next;
		}
	}
	
	/**
	 * 返回链表长度
	 * @method: nodeLength 
	 * @param head
	 * @return 
	 * @return int
	 */
	public static int nodeLength(Node head) {
		Node temp = head.next;
		int i = 0;
		while (temp != null) {
			temp = temp.next;
			i++;
		}
		return i;
	}
	
	
	/**
	 * 链表中插入数据
	 * @method: insertNode 
	 * @param head 首节点
	 * @param index 要插入的下标
	 * @param value 插入的数据
	 * @return void
	 */
	public static void insertNode(Node head,int index,int value) {
		
		//首先要判断插入的index是否合法
		if (index < 1 || index > nodeLength(head)) {
			System.out.println("输入不合法");
			return;
		}
		//从头节点开始遍历链表
		Node temp = head.next;
		int i = 0;
		//初始化要插入的节点
		Node node = new Node(value);
		//记录遍历的当前位置
		while(temp != null) {
			i++;
			if(index == i) {
				Node n = temp.next;
				temp.next = node;
				node.next = n;
				break;
			}
			temp = temp.next;
		}
	}
	
	/**
	 *  删除节点
	 * @method: deleteNode 
	 * @param head 首节点
	 * @param index 下标
	 * @return void
	 */
	public static void deleteNode(Node head,int index) {
		//首先判断index是否合法
		if(index < 1 || index > nodeLength(head)) {
			System.out.println("输入不合法");
			return;
		}
		//遍历node,index符合则删除
		Node temp = head;
		int i = 0;
		while(temp.next != null) {
			
			if(index-1 == i) {
				Node node = temp.next;
				temp.next = node.next;
				break;
			}
			i++;
			temp = temp.next;
		}
	}
	
	/**
	 * 链表排序
	 * @method: sort 
	 * @param head 
	 * @return void
	 */
	public static void sort(Node head) {
		//冒泡排序，即第一项依次与后面数据比较并交换，交换在内循环中
		//选择排序,效率比冒泡高，只需交换一次。 
		
	}
	
	public static void main(String[] args) {
		addData(1);
		addData(2);
		addData(3);
		addData(4);
//		traverse(head);
//		System.out.println("--------------");
//		insertNode(head, 4, 5);
//		traverse(head);
		System.out.println("--------------");
		deleteNode(head, 1);
		traverse(head);
	}
	
	
}
