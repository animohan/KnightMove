class nodez{
	int nodezpos_i, nodezpos_j;
	String nodezVal="0";
	boolean nodezVisited=false;
	void setnodezPos(int i, int j){
		nodezpos_i=i;
		nodezpos_j=j;
	}
	
	nodez(int i, int j, String a, boolean k){
		nodezpos_i=i;
		nodezpos_j=j;
		nodezVal=a;
		nodezVisited=k;
	}
	
	void setnodezVal(String a){
		nodezVal=a;
	}
	
	int[][] getNeighbor(){
		int neighbors[][]={{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int index=0;
		for(int i=-2;i<3;i++){
			 for(int j=-2;j<3;j++){
				 if(((i==-2 && j==-1)||(i==-2 && j==1)||(i==-1 && j==-2)||(i==-1 && j==2)||(i==1 && j==-2)||(i==1 && j==2)||(i==2 && j==-1)||(i==2 && j==1))&&(nodezpos_i+i>=0)&&(nodezpos_i+i<8)&&(nodezpos_j+j>=0)&&(nodezpos_j+j<8)){
					neighbors[index][0]=nodezpos_i+i;
					neighbors[index][1]=nodezpos_j+j;
					index++;
				 }
			 }
		}
		
		return neighbors;
	}
	
	
}

class KMovesPuzz{
	public static void main(String args[]){
	 
		String refcboard[][]={{" 00", " 01"," 02"," 03"," 04"," 05"," 06"," 07"},
				 			 {" 10"," 11"," 12"," 13"," 14"," 15"," 16"," 17"},
				 			 {" 20"," 21"," 22"," 23"," 24"," 25"," 26"," 27"},
				 			 {" 30"," 31"," 32"," 33"," 34"," 35"," 36"," 37"},
				 			 {" 40"," 41"," 42"," 43"," 44"," 45"," 46"," 47"},
				 			 {" 50"," 51"," 52"," 53"," 54"," 55"," 56"," 57"},
				 			 {" 60"," 61"," 62"," 63"," 64"," 65"," 66"," 67"},
				 			 {" 70"," 71"," 72"," 73"," 74"," 75"," 76"," 77"}};
				 			 
		 
		 nodez[][] cboard=new nodez[8][8];
		  for(int i=0;i<8;i++){
			 for(int j=0;j<8; j++){
				 cboard[i][j]=new nodez(i,j,refcboard[i][j],false);
				 //System.out.print(" i=" + cboard[i][j].nodezpos_i+ " j="+ cboard[i][j].nodezpos_j+ " nodez Value "+cboard[i][j].nodezVal+" nodez Visited="+cboard[i][j].nodezVisited+ ";");
			 }
			 //System.out.println();
		 }
		
		int initialpos_i=0, initialpos_j=0;
		int currentpos_i=0, currentpos_j=0;
		int finalpos_i=4,finalpos_j=4;
	  
		nodez[] nodezstack=new nodez[64];
		int tos=0;
		
		nodezstack[0]=new nodez(-1,-1,"a", false);
		nodezstack[0]=cboard[initialpos_i][initialpos_j];
		tos=0;
		int pathlen=0;
		dfs(tos,nodezstack,cboard,pathlen);

 
	}

	private static void dfs(int pass_tos, nodez[] pass_nodezstack, nodez[][] pass_cboard,int pass_pathlen) {
		 int tos=pass_tos;
		 int pathlen=pass_pathlen;
		 nodez[] nodezstack=pass_nodezstack;
		 nodez[][] cboard=pass_cboard;
		 int currpos_i=nodezstack[tos].nodezpos_i;
		 int currpos_j=nodezstack[tos].nodezpos_j;
		 
		 cboard[currpos_i][currpos_j].nodezVisited=true;
		 
		 int listofneighbors[][]={{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		 listofneighbors=nodezstack[tos].getNeighbor();
			 for(int i=0;i<7;i++){
				 if(listofneighbors[i][0]!=-1 ){
					 if(cboard[listofneighbors[i][0]][listofneighbors[i][1]].nodezVisited==true){
						continue;
					 }
					 else {
							 tos++;
							 pathlen++;
							 if (pathlen<10){
							 	 nodezstack[tos]=new nodez(-1,-1,"a",false);
							 	 nodezstack[tos]=cboard[listofneighbors[i][0]][listofneighbors[i][1]];
							 	 System.out.print(cboard[listofneighbors[i][0]][listofneighbors[i][1]].nodezVal);
							 	 dfs(tos,nodezstack,cboard,pathlen);
							 }
							 else{
								//System.out.println(" ");
								return; 
							 }
						 }
						 
					 }
				 		 
				 else{
					 System.out.println();
					return; 
					 
				 }
				 
				 
			 }
			  
	}
}