/** Intervalo fechado finito; implementação independente, sem dependência de algs4. */
public record Intervalo(double inicio, double fim) {
    public Intervalo {
        if(!Double.isFinite(inicio)||!Double.isFinite(fim)||inicio>fim)
            throw new IllegalArgumentException("Extremos devem ser finitos e ordenados");
    }
    public double comprimento(){ return fim-inicio; }
}
