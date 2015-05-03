class node{
	int nodepos_i, nodepos_j;
	String nodeVal="0";
	boolean nodeVisited=false;
	void setNodePos(int i, int j){
		nodepos_i=i;
		nodepos_j=j;
	}
	
	node(int i, int j, String a, boolean k){
		nodepos_i=i;
		nodepos_j=j;
		nodeVal=a;
		nodeVisited=k;
	}
	
	void setNodeVal(String a){
		nodeVal=a;
	}
	
	int[][] getNeighbor(){
		int neighbors[][]={{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int index=0;
		for(int i=-2;i<3;i++){
			 for(int j=-2;j<3;j++){
				 if(((i==-2 && j==-1)||(i==-2 && j==1)||(i==-1 && j==-2)||(i==-1 && j==2)||(i==1 && j==-2)||(i==1 && j==2)||(i==2 && j==-1)||(i==2 && j==1))&&(nodepos_i+i>0)&&(nodepos_i+i<8)&&(nodepos_j+j>0)&&(nodepos_j+j<8)){
					neighbors[index][0]=nodepos_i+i;
					neighbors[index][1]=nodepos_j+j;
					index++;
				 }
			 }
		}
		
		return neighbors;
	}
	
	
}

class kMovesdfs{
	public static void main(String args[]){
	/*	 char refcboard[][]= {{'a','b','c','d','e','f','g','h'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'},
				 			  {'a','b','c','d','e','f','g','h','i'}};
			 
		*/	 
		String refcboard[][]={{" 00", " 01"," 02"," 03"," 04"," 05"," 06"," 07"},
				 			 {" 10"," 11"," 12"," 13"," 14"," 15"," 16"," 17"},
				 			 {" 20"," 21"," 22"," 23"," 24"," 25"," 26"," 27"},
				 			 {" 30"," 31"," 32"," 33"," 34"," 35"," 36"," 37"},
				 			 {" 40"," 41"," 42"," 43"," 44"," 45"," 46"," 47"},
				 			 {" 50"," 51"," 52"," 53"," 54"," 55"," 56"," 57"},
				 			 {" 60"," 61"," 62"," 63"," 64"," 65"," 66"," 67"},
				 			 {" 70"," 71"," 72"," 73"," 74"," 75"," 76"," 77"}};
				 			 
		 
		 node[][] cboard=new node[8][8];
		  for(int i=0;i<8;i++){
			 for(int j=0;j<8; j++){
				 cboard[i][j]=new node(i,j,refcboard[i][j],false);
				 //System.out.print(" i=" + cboard[i][j].nodepos_i+ " j="+ cboard[i][j].nodepos_j+ " Node Value "+cboard[i][j].nodeVal+" Node Visited="+cboard[i][j].nodeVisited+ ";");
			 }
			 //System.out.println();
		 }
		
		int initialpos_i=0, initialpos_j=0;
		int currentpos_i=0, currentpos_j=0;
		int finalpos_i=4,finalpos_j=4;
	  
		int exitloop=0;
		node[] nodestack=new node[64];
		int tos=0;
		
		nodestack[0]=new node(-1,-1,"a", false);
		nodestack[0]=cboard[initialpos_i][initialpos_j];
		tos=0;
		dfs(tos,nodestack,cboard);

 
	}

	private static void dfs(int pass_tos, node[] pass_nodestack, node[][] pass_cboard) {
		 int tos=pass_tos;
		 node[] nodestack=pass_nodestack;
		 node[][] cboard=pass_cboard;
		 int currpos_i=nodestack[tos].nodepos_i;
		 int currpos_j=nodestack[tos].nodepos_j;
		 
		 cboard[currpos_i][currpos_j].nodeVisited=true;
		 
		 int listofneighbors[][]={{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		 listofneighbors=nodestack[tos].getNeighbor();
			 for(int i=0;i<7;i++){
				 if(listofneighbors[i][0]!=-1 ){
					 if(cboard[listofneighbors[i][0]][listofneighbors[i][1]].nodeVisited==true){
						 continue;
					 }
					 else {
						 tos++;
						 nodestack[tos]=new node(-1,-1,"a",false);
						 nodestack[tos]=cboard[listofneighbors[i][0]][listofneighbors[i][1]];
						 System.out.print(cboard[listofneighbors[i][0]][listofneighbors[i][1]].nodeVal);
						 dfs(tos,nodestack,cboard);
					 }
				 }
				 else{
					return; 
					 
				 }
				 
				 
			 }
			  
	}
}