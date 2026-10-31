# Collatz em C11

[Início](../../README.md) · [Como executar](../../README.md#como-executar) · [Aprendizagem](../../README.md#o-que-desenvolvi-e-aprendi) · [Estado atual](../../README.md#estado-atual)

> **Nesta área:** programa independente em C11, com limites de passos e checagem de overflow.

[Início](../../README.md) · [Como executar](../../README.md#como-executar) · [Aprendizagem](../../README.md#o-que-desenvolvi-e-aprendi) · [Estado atual](../../README.md#estado-atual)

> **Nesta área:** programa independente em C11, com limites de passos e checagem de overflow.

Implementação nova de estudo. Para cada n positivo: n par é dividido por dois; n ímpar é substituído por 3n+1. Contam-se passos e maior valor até chegar a um, atingir o orçamento de passos ou detectar overflow.

```sh
python scripts/verificar_collatz.py
./build/collatz 1 10
./build/collatz 27 27 100
```

No Windows use `build\collatz.exe`. É necessário compilador C11; `CC` permite indicá-lo. A validação remota deste módulo usa Ubuntu com cc. A suíte Java continua sendo verificada nas três plataformas.

O CSV tem n,passos,pico,estado. Saída zero indica que todos chegaram a um dentro do orçamento; código 1 indica entrada inválida e código 2, limite ou overflow em pelo menos um valor. Para n=27: 111 passos e pico 9232. O limite de 100 passos interrompe esse caso sem fingir conclusão.

O código verifica 3n+1 antes de calculá-lo com uint64_t. Não usa ponto flutuante para identificar paridade ou representar inteiros. São aceitos até 10.000 valores por chamada e orçamento de até 1.000.000 de passos por valor. Memória auxiliar O(1); tempo proporcional aos passos efetivamente executados.

**Testar entradas não prova a conjectura para todos os inteiros.** Esta versão não é apresentada como cópia do programa historicamente entregue. O relatório textual autorizado está em [acervo/](../../acervo/README.md), separado desta implementação nova.

---

**Projeto:** [MAC0122 · Algoritmos, invariantes e testes](../../README.md). Consulte a raiz para os requisitos e o primeiro comando; este guia aprofunda a área `src/collatz/`.

---

**Projeto:** [MAC0122 · Algoritmos, invariantes e testes](../../README.md). Consulte a raiz para os requisitos e o primeiro comando; este guia aprofunda a área `src/collatz/`.
