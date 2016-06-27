import java.lang.Math;
public class modulo{
public static void main(String[] args) {

int x = 44;
int N=x;
int s=0;
for(int i=0 ; i<N;i++){
	if (N%2==0){
		N=N/2;
	}
	else if (N%2!=0){
	s=1;
	}
	
}
if(s==1){
System.out.println(x + "is  not a power of 2");
int N1 = 1;
while(N1 < x)
   N1*=2;

System.out.println(N1 + "is the power of 2");
}

}
}
