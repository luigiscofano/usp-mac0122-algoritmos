# Acervo recuperado de MAC0122

[Relatório de Collatz de 2022](relatorio_collatz_2022.md): extração textual do documento de Luigi Scofano de Araujo, com publicação autorizada pelo autor. As imagens incorporadas não estão incluídas nesta extração.

## Ler criticamente

O documento descreve uma implementação histórica e mantém sua redação original. Não representa especificação da implementação atual e não comprova aprovação no avaliador antigo.

O operador `sizeof` pertence à linguagem C e não depende de stdlib.h. No módulo novo, paridade é inteira e o passo 3n+1 é checado contra overflow antes da operação. Essas escolhas evitam problemas de usar ponto flutuante para inteiros; não alteram silenciosamente o relatório recuperado.

[Implementação nova em C11](../src/collatz/README.md) · [Procedência](../docs/PROCEDENCIA.md) · [Validação](../docs/VALIDACAO.md)
