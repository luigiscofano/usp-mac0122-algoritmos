# E06 e T07 · Duas varreduras com invariantes diferentes

| Estudo | Entrada | Decisão segura | Custo |
| --- | --- | --- | --- |
| União | Intervalos fechados finitos | Após ordenar inícios, apenas o último componente pode intersectar o próximo | O(n log n) |
| Soma de pares | Vetor não decrescente | Soma pequena descarta o menor; soma grande descarta o maior | O(n) |

## Intervalos

Tocar na extremidade une componentes. [1,3], [2,4.5], [6,9] e [7,8] produzem [1,4.5] e [6,9], total 6.5 e dois componentes. A entrada não é alterada.

```sh
java -cp build/classes UnionOfIntervals -v examples/intervalos.txt
```

O SVG gerado está em build/intervalos.svg. Os doubles seguem aritmética finita; não há tolerância implícita para unir pontos numericamente próximos.

## Pares e duplicatas

No vetor [1,1,3,3], alvo 4 produz quatro pares de índices, não apenas um par de valores. Blocos distintos contribuem m·n; um bloco de k valores iguais contribui k(k−1)/2. A soma é promovida para long antes de operar.

```sh
java -cp build/classes BuscaEmAA 4 1 1 3 3
```

**Exercício:** encontre um contraexemplo para uma versão que avança apenas um ponteiro ao encontrar igualdade e ignora multiplicidades. Confronte com o oráculo quadrático da suíte.
