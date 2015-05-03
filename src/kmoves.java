class kmoves{
	 public static void main(String args[]){
		 
		 char cboard[][]={{'a','b','c','d','e','f','g','h'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'},{'a','b','c','d','e','f','g','h','i'}};
		 int visitmap[][]={{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		 int i=0, j=0;
		 
		 int initialpos_i=0, initialpos_j=0;
		 int basepos_i=0, basepos_j=0;
		 int finalpos_i=8,finalpos_j=8;

		 int pathmap[][]=new int[200][3];
		 int exitloop=0;
		 int currentpos_i=0, currentpos_j=0,newpos_i=0, newpos_j=0;
		  
		 pathmap[0][0]= 0;
		 pathmap[0][1]=basepos_i;
		 pathmap[0][2]=basepos_j;
		 int pathlen=0;
		 int beginindex=-1,endindex=0;
		 
		 while (exitloop<10){		
			 
			 beginindex++;
			 currentpos_i=pathmap[beginindex][1];
			 currentpos_j=pathmap[beginindex][2];
			 
			 visitmap[currentpos_i][currentpos_j]=1;
			 
			 pathlen++;
			 for(i=-2;i<3;i++){
				 for(j=-2;j<3;j++){
							 
				 if((i==-2 && j==-1)||(i==-2 && j==1)||(i==-1 && j==-2)||(i==-1 && j==2)||(i==1 && j==-2)||(i==1 && j==2)||(i==2 && j==-1)||(i==2 && j==1)) { 	 
					 newpos_i=currentpos_i+i;
					 newpos_j=currentpos_j+j;
									
					 if(newpos_i>=0 && newpos_i<8 && newpos_j>=0 && newpos_j<8 && visitmap[newpos_i][newpos_j]==0){
						 endindex++;
						 pathmap[endindex][0]=pathlen;
						 pathmap[endindex][1]=newpos_i;
						 pathmap[endindex][2]=newpos_j;	
						
					 } 
				 }
				 
				}
			 }

				exitloop++;
			 }
		 
		 
		 for(i=0;i<pathlen;i++){
			 System.out.print(pathmap[i][0]+ " "+ pathmap[i][1]+" "+ pathmap[i][2]);
			 System.out.println();
			 }
		 } 
		 
	 }

class knight{
	int currentpos_i=0;
	int currentpos_j=0;
	
	void setCurrentpos(int i, int j){
		currentpos_i=i;
		currentpos_j=j;
	}
	
	void nextPos(int i, int j){
		
	}
	
	
}