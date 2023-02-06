package HW4;

import java.util.ArrayList;

public class Main {
	
	
	public static void main(String[] args) {
		int n = 8;                         //обозначаем размеры карты
		int m = 8;
		Node start = new Node(3,3,1);      //обозначаем координаты ячейки старт
		
		Node finish = new Node (n-1,m-1,0);
		finish.way = true; 
		finish.b = 1;      // обозначаем координаты ячейки финиша если он находиться вправа внизу
		
		ArrayList<Node> map = new ArrayList<Node>();
		
		int y = 0;                         //начало метода заполнения карты ячейками с координатами
		int x = 0;
		for(int i = 0; i <n*m ; i++){
			if( x < n ){
				map.add(new Node(x,y,0));
				x++;
			}
			if ( x == n ){
				x = 0;
				y++;
			}
		}                                 // конец метода заполнения карты
		
		for(int i = 0; i < map.size(); i++){                           // начало метода вставки старта
			if(start.x == map.get(i).x && start.y == map.get(i).y){
				map.set(i,start);
			}
		}                                                              // конец метода вставки старта
		
		
		
		
		
		for(int i = 0; i < map.size(); i++){                           // начало метода вставки финиша
			if(finish.x == map.get(i).x && finish.y == map.get(i).y){
				map.set(i,finish);
			}
		}                                                              // конец метода вставки финиша
		
		
		while(finish.a == 0){                                                       //начало метод алгоритма Ли 
		    for(int i = 0; i < map.size(); i++){
					if(map.get(i).a > 0){
						for( int j = 0; j < map.size(); j++){
							if(map.get(j).a == 0 && map.get(j).x == map.get(i).x - 1
							                     && map.get(j).y == map.get(i).y){
							                     	map.get(j).a = map.get(i).a + 1;
							                     }
							if(map.get(j).a == 0 && map.get(j).x == map.get(i).x + 1
							                     && map.get(j).y == map.get(i).y){
							                     	map.get(j).a = map.get(i).a + 1;
							                     }
							if(map.get(j).a == 0 && map.get(j).x == map.get(i).x
							                     && map.get(j).y == map.get(i).y - 1){
							                     	map.get(j).a = map.get(i).a + 1;
							                     }
							if(map.get(j).a == 0 && map.get(j).x == map.get(i).x
							                     && map.get(j).y == map.get(i).y + 1){
							                     	map.get(j).a = map.get(i).a + 1;
							                     }
						}
					}
			}
		}                                                               //конец метода алгоритма Ли
		
		while(start.b == 0){                                     //начало метода поиска числа b для старта
			for(int i = 0; i < map.size(); i++){
				if(map.get(i).b == 0 )
				for(int j = 0; j < map.size(); j++){
					if(map.get(i).a == map.get(j).a-1 && map.get(j).way == true 
					                                  && map.get(i).x == map.get(j).x-1 
					                                  && map.get(i).y == map.get(j).y ){
						map.get(i).way = true;
						map.get(i).b = map.get(i).b + map.get(j).b;
					}
					if(map.get(i).a == map.get(j).a-1 && map.get(j).way == true 
					                                  && map.get(i).x == map.get(j).x+1 
					                                  && map.get(i).y == map.get(j).y){
						map.get(i).way = true;
						map.get(i).b = map.get(i).b + map.get(j).b;
					}
					if(map.get(i).a == map.get(j).a-1 && map.get(j).way == true 
					                                  && map.get(i).x == map.get(j).x 
					                                  && map.get(i).y == map.get(j).y-1){
						map.get(i).way = true;
						map.get(i).b = map.get(i).b + map.get(j).b;
					}
					if(map.get(i).a == map.get(j).a-1 && map.get(j).way == true
					                                  && map.get(i).x == map.get(j).x 
					                                  && map.get(i).y == map.get(j).y+1){
						map.get(i).way = true;
						map.get(i).b = map.get(i).b + map.get(j).b;
					}
				}
			  }
			}                                                        // конец метода поиска числа b для старта
		
		
		for(int i = 0; i < map.size(); i++){
			map.get(i).print(); // это для проверки
		}
		// нужно выдернуть с массива элемент с координатами старта число b это количество кратчайших путей
		// число (b-1) финиша это количество ходов в кратчайшем пути
		// эта программа учитывает стенки но метод для ввоода стенок нужно отдельно написать вставляя элементы            в массив с числом а = -1, можно сделать таким же путем как старт и финиш вставляются
	}
	
	
}
    class Node{                  //класс ячейка
		boolean way;
		int a = 0;
		int b = 0;
		int x = 0;
		int y = 0;
		
		Node(int x, int y, int a){
			this.a = a;
			this.x = x;
			this.y = y;
		}
		

		public void print(){     // это для проверки
			System.out.println(a + " " + x + " " + y +" " + way + " " + b);
		}
	}
