import java.util.*;

/** Reconstrução didática de 2026; não é uma cópia autenticada da entrega de 2023. */
public final class FindGene {
    public record Gene(int inicio, int fim) {} // Fim exclusivo, incluindo o stop codon.
    private static boolean stop(String dna, int i) {
        return dna.startsWith("TAA", i) || dna.startsWith("TAG", i) || dna.startsWith("TGA", i);
    }
    public static List<Gene> buscar(String dna) {
        Objects.requireNonNull(dna, "DNA ausente");
        if (!dna.matches("[ACGT]*")) throw new IllegalArgumentException("Use apenas A, C, G e T maiúsculos");
        int n=dna.length();
        int[] proximo=new int[n];
        int[] porQuadro={-1,-1,-1};
        // O primeiro stop à direita em cada quadro permite consultar cada início em O(1).
        for (int i=n-1;i>=0;i--) {
            proximo[i]=porQuadro[i%3];
            if (i+3<=n && stop(dna,i)) porQuadro[i%3]=i;
        }
        List<Gene> genes=new ArrayList<>();
        for (int i=0;i+3<=n;i++)
            if (dna.startsWith("ATG",i) && proximo[i]>=i+3)
                genes.add(new Gene(i,proximo[i]+3));
        return List.copyOf(genes);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String dna=in.hasNext()?in.next():"";
        if(in.hasNext()) throw new IllegalArgumentException("Informe uma única sequência");
        for(Gene g:buscar(dna)) System.out.println(dna.substring(g.inicio(),g.fim()));
    }
}
