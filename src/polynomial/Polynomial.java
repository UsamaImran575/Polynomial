/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;
import java.util.Collections;
/**
 *
 * @author Usama Sheikh
 */
public class Polynomial {

 
    private int[] cS;  // coefficients
    private int d;     // degree of polynomial (0 for the zero polynomial)


    // a * x^b
    public Polynomial( int deg, int[] coff ){
        cS = new int[ deg+1];
        for(int i=0;i<=deg;i++)
        {
            cS[i]=coff[i];
        }
        d=deg;
    }

   
    public int getdegree()
    {
        return d;
    }
    public int getcoff(int index)
    {
        if(this.d>=index){
        return cS[index];    
        }
        return 0;
    }
      
    // return c = a + b
    public Polynomial plus( Polynomial b ){
        Polynomial a = this;
        int d;
        if(a.getdegree()>=b.getdegree())
        {
            d=a.getdegree();
        }
        else{
            d=b.getdegree();
        }
        int coff[];
        coff=new int[d+1];
        
        for(int i=0;i<=d;i++)
        {
            coff[i]=a.getcoff(i)+b.getcoff(i);
        }
        Polynomial c=new Polynomial(d,coff); 
        return c;
    }


    // return (a - b)
    public Polynomial minus( Polynomial b ){
        Polynomial a = this;
        int d;
        if(a.getdegree()>=b.getdegree())
        {
            d=a.getdegree();
        }
        else{
            d=b.getdegree();
        }
        int coff[];
        coff=new int[d+1];
        
        for(int i=0;i<=d;i++)
        {
            coff[i]=a.getcoff(i)-b.getcoff(i);
        }
        Polynomial c=new Polynomial(d,coff); 
        return c;
    }


    // return (a * b)
    public Polynomial multiply( Polynomial b ){
        int coff[];
        int d=this.getdegree()+b.getdegree()+1;
        coff=new int[d];
        for (int i = 0; i <= this.getdegree(); i++)
            for (int j = 0; j <= b.getdegree(); j++)
                coff[i+j] += (this.getcoff(i) * b.getcoff(j));
        for(int i=d-1;i>=0;i--)
        {
            if(coff[i]!=0)
            {
                d=i;
                break;
            }
        }
        Polynomial poly = new Polynomial(d, coff);
        return poly;
    }
   @Override
    public String toString() {
        if      (d == -1) return "0";
        else if (d ==  0) return "" + cS[0];
        else if (d ==  1) return cS[1] + "x + " + cS[0];
        String s = cS[d] + "x^" + d;
        for (int i = d - 1; i >= 0; i--) {
            if      (cS[i] == 0) continue;
            else if (cS[i]  > 0) s = s + " + " + (cS[i]);
            else if (cS[i]  < 0) s = s + " - " + (-cS[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }

    
}
    

