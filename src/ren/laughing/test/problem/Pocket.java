package ren.laughing.test.problem;
public class Pocket{
  /**
  * n:红包数
  * m: 每个红包中的金额
  * 返回结果为出现次数最多的红包金额
  */
  public static double getmost(int n,double[] m){
      int[] k = null ;
    double[] l= null; 
    for(int i = 0;i< m.length;i++){
      for(int j = i;j<m.length;j++){
        if(m[i]-m[j+1]==0){
             k[i]+=1;	
        }
      }
      l[i] = m[i];
    }
    for(int i =0;i<k.length;i++){
      for(int j=i;j<k.length;j++){
        if(k[i]-k[j]<0){
          int a = k[i];
          k[i] = k[j];
          k[j] = a;
          double b =l[i];
          l[i] = l[j];
          l[j] = b;
        }
      }
    }
    return l[0];
  }
  public static void main(String[] args) {
	getmost(10,new double[6]);
}
}
