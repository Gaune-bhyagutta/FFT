import java.util.Scanner;
//Radix-2 FFT implementation
// Here the input to the fft is a real number and output is complex number

public class FFt {

    
    public static Complex[] fft(Complex[] x) {
        int N = x.length;

        
        if (N == 1) return new Complex[] { x[0] };

      
       if (N % 2 != 0) {
       		System.out.println(" Invalid number of Input for FFT");
        	System.exit(0);             
        }
        
        // Splitting the odd and even terms for calculation of FFT
        // fft of even terms
        Complex[] even = new Complex[N/2];
        for (int k = 0; k < N/2; k++) {
            even[k] = x[2*k];
        }
        Complex[] q = fft(even);

        // fft of odd terms
        Complex[] odd  = even;  
        for (int k = 0; k < N/2; k++) {
            odd[k] = x[2*k + 1];
        }
        Complex[] r = fft(odd);

        // combine
        Complex[] y = new Complex[N];
        for (int k = 0; k < N/2; k++) {
            double kth = -2 * k * Math.PI / N;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k]       = q[k].plus(wk.times(r[k]));
            y[k + N/2] = q[k].minus(wk.times(r[k]));
        }
        return y;
    }

 public static void print(Complex[] x) {
        
        for (int i = 0; i < x.length; i++) {
        	String a= x[i].toString();
            System.out.println(a);
        }
        System.out.println();
    }

   
   


   
    public static void main(String[] args) { 
        int N=3;
        int M=N;
                       
       
       Scanner in = new Scanner(System.in);
       double [] ax= new double[N];
       
       for(int i=0;i<N;i++){
       	ax[i]= in.nextDouble();
       }
      
      // checking if N is a power of 2 or not 
       int s=0;
	for(int i=0 ; i<M;i++){
		if (M%2==0){
			M=M/2;
		}
		else if (M%2!=0){
		s=1;
		}
	
	}
	
	if(s==1){// if N is not a power of 2

	int N1 = 1;
	while(N1 < N)
	   {N1*=2;}
       
       
       Complex[] x = new Complex[N1];           
        
        for (int i = 0; i < N; i++) {
            
            x[i] =new Complex(ax[i],0);
        }
        
        for (int i =N ; i < N1; i++) {// zero padding till the number is power of 2
            
            x[i] =new Complex(0,0);
        }
        System.out.println("Input");
	
        print(x);
        Complex[] y = fft(x);
        
        System.out.println("Output of FFT");
        print(y);
        } 
        
             
        
        else{// when N is already a power of 2
        	Complex[] x = new Complex[N];           
        
        for (int i = 0; i < N; i++) {
            
            x[i] =new Complex(ax[i],0);
        }
        
        System.out.println("Input");
	
        print(x);
        Complex[] y = fft(x);
        
        System.out.println("Output of FFT");
        print(y);
        
        }
                
        

        // FFT of original data
        
        
       /*System.out.println("absolute value");
        double[] a=new double[x.length];
        for(int i=0;i<x.length;i++){
        	a[i]=y[i].abs();
        	System.out.println(a[i]);
        }*/

        
    }


}
