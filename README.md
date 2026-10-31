# MAC0122 · Algoritmos, invariantes e testes

> Quatro estudos independentes: busca de genes, união de intervalos, contagem de pares e Collatz em C11, com exemplos, análise de complexidade e testes reproduzíveis.

![Visão geral de MAC0122 · Algoritmos, invariantes e testes](assets/capa.svg)

[![Verificação](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/workflows/verificacao.yml/badge.svg?branch=main)](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/workflows/verificacao.yml)

[O que faz](#o-que-este-projeto-faz) · [Módulos](#funcionalidades-e-módulos) · [Executar](#como-executar) · [Aprendizagem](#o-que-desenvolvi-e-aprendi) · [Estado atual](#estado-atual) · [Documentação](#documentação-e-navegação)

## O que este projeto faz

Reúne problemas de **Princípios de Desenvolvimento de Algoritmos — MAC0122**. Cada programa recebe uma entrada simples e resolve um problema específico: identificar sequências em DNA, unir intervalos, contar somas de pares ou percorrer sequências de Collatz. As três primeiras implementações usam Java; Collatz usa C11 e é uma extensão independente.

## Qual problema resolve

O objetivo é compreender por que um algoritmo é correto e eficiente, além de obter uma saída. Cada estudo explicita contrato, invariante, custo e casos de fronteira. Os testes comparam várias entradas com referências mais simples, em vez de depender apenas de um exemplo visual.

## Funcionalidades e módulos

| Estudo | Entrada → saída | Ideia principal | Custo |
| --- | --- | --- | --- |
| Genes | String A/C/G/T → coordenadas e subsequências | Próximo stop por quadro de leitura | O(n+g), mais os caracteres impressos |
| Intervalos | Pares de extremos → componentes da união e comprimento | Ordenar e varrer | O(n log n) |
| Busca em A+A | Vetor ordenado + alvo → número de pares de índices | Dois ponteiros e multiplicidades | O(n) |
| Collatz | Intervalo de inteiros → passos, pico e estado em CSV | Iteração limitada com checagem de overflow | Proporcional aos passos executados |

### 1. Genes — E05

`FindGene` procura cada `ATG` e o primeiro `TAA`, `TAG` ou `TGA` no mesmo quadro. Coordenadas são baseadas em zero e têm fim exclusivo, incluindo o stop. Inícios sobrepostos são preservados: `ATGATGATGTAA` gera três resultados. O programa de terminal imprime as subsequências; a API retorna coordenadas imutáveis. É um modelo de exercício, não uma ferramenta de anotação biológica completa.

### 2. União de intervalos — E06

`Intervalo` representa extremos finitos, com início menor ou igual ao fim. `UnionOfIntervals` não modifica a entrada e une intervalos **fechados**, inclusive quando apenas se tocam. No modo `-v`, lista componentes e gera um SVG. Usa `double`, sem uma tolerância geométrica implícita.

### 3. Contagem de pares — T07

`BuscaEmAA` exige vetor ordenado e conta índices distintos i<j, conservando multiplicidades. `[1,1,3,3]`, com alvo 4, tem quatro pares, não um. A soma é promovida para `long` antes de operar; uma entrada não ordenada é rejeitada.

### 4. Collatz — estudo em C11

Para n positivo, divide pares por dois e transforma ímpares em 3n+1, registrando passos e maior valor. O programa verifica overflow de `uint64_t` antes da operação e pode interromper por orçamento. Aceita até 10.000 valores por chamada e até 1.000.000 de passos por valor. **Experimentos finitos não provam a conjectura.** O [relatório de 2022](acervo/README.md) foi recuperado; o código C desta edição é novo e seus limites estão identificados.

## Como executar

**Requisitos:** JDK 17 ou superior, com `java` e `javac` no PATH; Python 3.12 para o verificador. O JRE sozinho não contém o compilador. Não há dependência de Maven ou Gradle na suíte nova.

```sh
git clone https://github.com/luigiscofano/usp-mac0122-algoritmos.git
cd usp-mac0122-algoritmos
```

Confira o ambiente:

```sh
java -version
javac -version
python --version
```


### Compilar e testar Java

```sh
python scripts/verificar.py
```

O script compila `src/` e `tests/`, executa `AlgoritmosTest` e grava evidências em `build/`. Não instala Java automaticamente.

### Rodar cada programa

```sh
echo ATGATGATGTAA | java -cp build/classes FindGene
java -cp build/classes UnionOfIntervals -v examples/intervalos.txt
java -cp build/classes BuscaEmAA 4 1 1 3 3
```

O primeiro imprime `ATGATGATGTAA`, `ATGATGTAA` e `ATGTAA`. O terceiro imprime `4`. O segundo escreve `build/intervalos.svg`, que pode ser aberto no navegador.

Para observar uma união com resultado exato de 6.5 e dois componentes:

```sh
echo "1 3 2 4.5 6 9 7 8" | java -cp build/classes UnionOfIntervals -v
```

### Compilar e testar Collatz

Requer também um compilador C11 no PATH. `CC` permite escolher outro compilador compatível.

```sh
python scripts/verificar_collatz.py
./build/collatz 1 10
./build/collatz 27 27
```

No Windows, use `build\collatz.exe`. Para 27, são esperados 111 passos e pico 9232. `./build/collatz 27 27 100` deve interromper por limite, em vez de declarar conclusão. Saídas 1 e 2 indicam, respectivamente, entrada inválida e interrupção/overflow.

## O que desenvolvi e aprendi

As implementações desta edição, seus exemplos e a suíte de verificação exercitam invariantes, varreduras, ordenação, complexidade com volume de saída, multiplicidades e limites numéricos. A recuperação dos temas acadêmicos e a origem de cada implementação estão em [PROCEDENCIA.md](docs/PROCEDENCIA.md).

**Atividade pedagógica:** explique por que guardar apenas o último ATG perde genes; construa um caso em que ignorar duplicatas erra a soma de pares; justifique por que somente o último componente da união pode se sobrepor ao próximo intervalo. [Atividades e rubrica](docs/OBJETIVOS_PEDAGOGICOS.md).

## Estado atual

| Situação | Recursos |
| --- | --- |
| Implementado | Três programas Java e API de apoio; Collatz C11; SVG; exemplos; testes e CI |
| Cobertura documentada | 5.000 DNAs, 5.000 vetores, 500 uniões e casos de fronteira; verificações próprias de Collatz |
| Limites | Modelo simplificado de genes, aritmética double nos intervalos, orçamento finito em Collatz |
| Histórico | Temas recuperados; fontes antigos de Java não autenticados; relatório Collatz preservado separadamente |

## Validação e limites

Os programas não usam o corretor antigo da disciplina. A CI testa Java em Linux/macOS/Windows; o módulo C tem job próprio em Ubuntu. Os [contratos](docs/ARQUITETURA.md) e a [validação](docs/VALIDACAO.md) permitem conferir exatamente as conclusões. Uma saída correta para um exemplo não substitui o invariante ou um teste independente.

## Documentação e navegação

| Caminho | Conteúdo |
| --- | --- |
| [src/](src/README.md) e [Collatz](src/collatz/README.md) | Implementações e contratos locais |
| [Guias por assunto](docs/topicos/README.md) | Genes, intervalos e pares |
| [examples/](examples/README.md) e [tests/](tests/README.md) | Entradas e referências de verificação |
| [acervo/](acervo/README.md) | Relatório histórico e leitura crítica |
| [docs/](docs/README.md) | Arquitetura, pedagogia, instalação, apresentação e validação |
| [Branches](docs/BRANCHES.md) e [PRs](docs/PUBLICACAO.md) | Organização das entregas |


## Autoria, referências e licença

**Luigi Scofano de Araujo · Engenharia de Computação, Poli-USP · USP 13680334.** Fontes recuperados, componentes de terceiros e trabalhos em grupo mantêm os créditos indicados nos arquivos e na documentação.

[Direitos e créditos](DIREITOS_E_CREDITOS.md) · [Procedência](docs/PROCEDENCIA.md) · [Como contribuir](CONTRIBUTING.md) · [Mudanças](CHANGELOG.md)

## Tópicos do repositório

`java` · `c` · `c11` · `algorithms` · `data-structures` · `two-pointers` · `intervals` · `collatz` · `property-based-testing` · `usp` · `educational`
