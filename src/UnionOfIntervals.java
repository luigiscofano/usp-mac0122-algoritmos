import java.util.*;
import java.nio.file.*;
import java.io.*;

public final class UnionOfIntervals {
    public static List<Intervalo> unir(Collection<Intervalo> entrada){
        List<Intervalo> ordenados=new ArrayList<>(entrada);
        ordenados.sort(Comparator.comparingDouble(Intervalo::inicio).thenComparingDouble(Intervalo::fim));
        List<Intervalo> resultado=new ArrayList<>();
        for(Intervalo novo:ordenados){
            if(resultado.isEmpty()||novo.inicio()>resultado.get(resultado.size()-1).fim()) resultado.add(novo);
            else {
                Intervalo ultimo=resultado.remove(resultado.size()-1);
                resultado.add(new Intervalo(ultimo.inicio(),Math.max(ultimo.fim(),novo.fim())));
            }
        }
        return List.copyOf(resultado);
    }
    public static String svg(List<Intervalo> intervalos){
        double min=intervalos.stream().mapToDouble(Intervalo::inicio).min().orElse(0);
        double max=intervalos.stream().mapToDouble(Intervalo::fim).max().orElse(1);
        double escala=max>min?700/(max-min):1;
        StringBuilder s=new StringBuilder("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"800\" height=\""+(80+35*intervalos.size())+"\"><rect width=\"100%\" height=\"100%\" fill=\"#101c2e\"/>");
        for(int i=0;i<intervalos.size();i++){
            Intervalo t=intervalos.get(i);double x=50+(t.inicio()-min)*escala,y=40+35*i;
            s.append(String.format(Locale.ROOT,"<line x1=\"%.3f\" y1=\"%.3f\" x2=\"%.3f\" y2=\"%.3f\" stroke=\"#52d6bf\" stroke-width=\"8\" stroke-linecap=\"round\"/><text x=\"50\" y=\"%.3f\" fill=\"white\" font-family=\"sans-serif\" font-size=\"12\">[%s, %s]</text>",x,y,50+(t.fim()-min)*escala,y,y+18,t.inicio(),t.fim()));
        }
        return s.append("</svg>").toString();
    }
    public static void main(String[] args)throws IOException {
        boolean verbose=false;String arquivo=null;
        for(String a:args){if(a.equals("-v"))verbose=true;else if(arquivo==null)arquivo=a;else throw new IllegalArgumentException("Uso: UnionOfIntervals [-v] [arquivo]");}
        Scanner in=arquivo==null?new Scanner(System.in):new Scanner(Path.of(arquivo));in.useLocale(Locale.ROOT);
        List<Intervalo> todos=new ArrayList<>();
        while(in.hasNext()){
            if(!in.hasNextDouble())throw new IllegalArgumentException("Extremo inválido");double a=in.nextDouble();
            if(!in.hasNextDouble())throw new IllegalArgumentException("Par incompleto");todos.add(new Intervalo(a,in.nextDouble()));
        }
        List<Intervalo> uniao=unir(todos);
        if(verbose){for(Intervalo t:uniao)System.out.println(t.inicio()+" "+t.fim());Files.createDirectories(Path.of("build"));Files.writeString(Path.of("build/intervalos.svg"),svg(uniao));}
        double total=uniao.stream().mapToDouble(Intervalo::comprimento).sum();
        if(!Double.isFinite(total))throw new ArithmeticException("Comprimento fora do intervalo double");
        System.out.printf(Locale.ROOT,"Total length: %s [%d components]%n",total,uniao.size());
    }
}
