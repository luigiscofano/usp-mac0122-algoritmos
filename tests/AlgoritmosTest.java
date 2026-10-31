import java.util.*;
public final class AlgoritmosTest {
    static void exigir(boolean c){if(!c)throw new AssertionError();}
    static List<FindGene.Gene> oraculo(String d){
        List<FindGene.Gene> out=new ArrayList<>();
        for(int i=0;i+3<=d.length();i++)if(d.startsWith("ATG",i))
            for(int j=i+3;j+3<=d.length();j+=3)if(Set.of("TAA","TAG","TGA").contains(d.substring(j,j+3))){out.add(new FindGene.Gene(i,j+3));break;}
        return out;
    }
    public static void main(String[] args){
        Random r=new Random(13680334);
        for(int k=0;k<5000;k++){
            StringBuilder d=new StringBuilder();for(int j=0,n=r.nextInt(100);j<n;j++)d.append("ACGT".charAt(r.nextInt(4)));
            exigir(FindGene.buscar(d.toString()).equals(oraculo(d.toString())));
            int[] a=new int[r.nextInt(50)];for(int j=0;j<a.length;j++)a[j]=r.nextInt(21)-10;Arrays.sort(a);long alvo=r.nextInt(41)-20,bruto=0;
            for(int i=0;i<a.length;i++)for(int j=i+1;j<a.length;j++)if((long)a[i]+a[j]==alvo)bruto++;
            exigir(BuscaEmAA.contar(a,alvo)==bruto);
        }
        exigir(FindGene.buscar("ATGATGATGTAA").size()==3);
        exigir(FindGene.buscar("ATGTAGATGTGAATGTAA").size()==3);
        exigir(BuscaEmAA.contar(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE},4294967294L)==1);
        for(int k=0;k<500;k++){
            List<Intervalo> in=new ArrayList<>();boolean[] coberto=new boolean[20];
            for(int j=0;j<30;j++){int a=r.nextInt(20),b=r.nextInt(20);int lo=Math.min(a,b),hi=Math.max(a,b);in.add(new Intervalo(lo,hi));for(int m=lo;m<hi;m++)coberto[m]=true;}
            double esperado=0;for(boolean b:coberto)if(b)esperado++;
            List<Intervalo> out=UnionOfIntervals.unir(in);exigir(out.stream().mapToDouble(Intervalo::comprimento).sum()==esperado);
            for(int j=1;j<out.size();j++)exigir(out.get(j-1).fim()<out.get(j).inicio());
        }
        exigir(UnionOfIntervals.unir(List.of()).isEmpty());
        exigir(UnionOfIntervals.unir(List.of(new Intervalo(0,1),new Intervalo(1,2))).size()==1);
        try{new Intervalo(Double.NaN,1);throw new AssertionError();}catch(IllegalArgumentException ok){}
        try{BuscaEmAA.contar(new int[]{2,1},3);throw new AssertionError();}catch(IllegalArgumentException ok){}
        try{FindGene.buscar("AN");throw new AssertionError();}catch(IllegalArgumentException ok){}
        System.out.println("PASS: 5000 DNAs, 5000 contagens de pares, 500 unioes e casos de borda");
    }
}
