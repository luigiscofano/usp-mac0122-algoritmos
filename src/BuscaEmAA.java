/** Conta pares de índices distintos i<j; duplicatas contam pela multiplicidade. */
public final class BuscaEmAA {
    public static long contar(int[] a,long alvo){
        for(int i=1;i<a.length;i++)if(a[i]<a[i-1])throw new IllegalArgumentException("Vetor deve estar ordenado");
        int lo=0,hi=a.length-1;long pares=0;
        while(lo<hi){
            long soma=(long)a[lo]+a[hi];
            if(soma<alvo)lo++;
            else if(soma>alvo)hi--;
            else if(a[lo]==a[hi]){long n=hi-lo+1L;pares+=n*(n-1)/2;break;}
            else {int v=a[lo],w=a[hi];long n=0,m=0;while(lo<=hi&&a[lo]==v){lo++;n++;}while(hi>=lo&&a[hi]==w){hi--;m++;}pares+=n*m;}
        }
        return pares;
    }
    public static void main(String[] args){
        if(args.length<1)throw new IllegalArgumentException("Uso: BuscaEmAA alvo [valores ordenados]");
        int[] a=new int[args.length-1];for(int i=0;i<a.length;i++)a[i]=Integer.parseInt(args[i+1]);
        System.out.println(contar(a,Long.parseLong(args[0])));
    }
}
