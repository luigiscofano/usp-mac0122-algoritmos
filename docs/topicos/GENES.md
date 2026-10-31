# E05 · Genes e quadros de leitura

Entrada: sequência maiúscula A/C/G/T. Saída: coordenadas de todos os inícios ATG ligados ao primeiro TAA, TAG ou TGA no mesmo quadro, com o stop incluído. Este é o contrato explícito da reconstrução atual.

## Acompanhe o mecanismo

Para `ATGATGATGTAA`, os inícios são 0, 3 e 6; o stop começa em 9. As três saídas terminam em 12, exclusive. Um algoritmo que só guarda o último ATG perde duas delas.

A passagem da direita guarda o próximo stop por `i % 3`; a passagem da esquerda consulta esse índice por início. Buscar coordenadas custa O(n+g). Materializar as strings acrescenta o tamanho total do texto produzido.

```sh
python scripts/verificar.py
java -cp build/classes FindGene < examples/dna.txt
```

**Exercício:** explique por que `(ATG)^m TAA` possui m resultados sob este contrato. Depois retire o stop e preveja a saída vazia.

**Evidência:** 5.000 sequências confrontadas com um oráculo de varredura direta. Isso valida implementação em casos exercitados, sem autenticar a entrega histórica.

[Arquitetura e contratos](../ARQUITETURA.md) · [Objetivos](../OBJETIVOS_PEDAGOGICOS.md)
