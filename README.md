<p align="center"><img src="assets/capa.svg" alt="MAC0122 · Princípios de Desenvolvimento de Algoritmos" width="100%"></p>

# MAC0122 · Princípios de Desenvolvimento de Algoritmos

**Da força bruta ao invariante: genes, intervalos e busca em A+A.**

[![Verificação](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/workflows/verificacao.yml/badge.svg?branch=main)](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/workflows/verificacao.yml)

Portfólio de **Luigi Scofano de Araujo · Engenharia de Computação, Poli-USP · USP 13680334**. Organização e complementos de 2026 com assistência de IA, distinguindo acervo recuperado e implementações novas. [Procedência](docs/PROCEDENCIA.md).

## Objetivos pedagógicos em destaque

- **Construir invariantes** — Manter todos os inícios ATG e o primeiro stop em cada quadro.
- **Separar busca e volume da saída** — Retornar coordenadas antes de criar substrings.
- **Justificar uma decisão gulosa** — Ordenar e unir intervalos fechados.
- **Contar multiplicidades** — Aplicar dois ponteiros com valores repetidos.
- **Evitar overflow** — Somar dois int em long.

**[Atividades, evidências e rubrica →](docs/OBJETIVOS_PEDAGOGICOS.md)**

## Execute e experimente

```sh
python scripts/verificar.py
java -cp build/classes FindGene < examples/dna.txt
java -cp build/classes UnionOfIntervals -v examples/intervalos.txt
java -cp build/classes BuscaEmAA 4 1 1 3 3
```

Ambiente: **Java 17+ e Python 3.12**. [Instalação detalhada](docs/INSTALACAO.md).

## Encontre cada parte

| Diretório | Conteúdo |
| --- | --- |
| [src/](src/README.md) | Implementações independentes em Java: FindGene, Intervalo, UnionOfIntervals e BuscaEmAA. |
| [tests/](tests/README.md) | Oráculos independentes e verificações diferenciais com semente fixa. |
| [examples/](examples/README.md) | DNA e intervalos sintéticos para reprodução. |
| [assets/](assets/README.md) | Capa vetorial e visualização da união gerada pelo programa. |
| [docs/](docs/README.md) | Arquitetura, objetivos, reprodução, apresentação e evidência |

## Verificação e limites

5.000 DNAs e 5.000 vetores com duplicatas confrontados com oráculos; 500 uniões comparadas com cobertura de segmentos inteiros. Casos adicionais: stops, sobreposições, vazio, extremos de int, NaN e entradas inválidas.

Sem autenticação dos fontes antigos ou execução no corretor de 2023; sem Interval1D/StdDraw; união em double sem geometria exata; tempos não usados como critério de aprovação.

**[Validação →](docs/VALIDACAO.md)** · **[Arquitetura e decisões →](docs/ARQUITETURA.md)**

Use o [roteiro de apresentação](docs/APRESENTACAO.md) e confira os [PRs reais](docs/PUBLICACAO.md). As branches representam organização atual, sem datas retroativas ou revisões fictícias.

[Contribuir](CONTRIBUTING.md) · [Direitos e créditos](DIREITOS_E_CREDITOS.md) · [Referências](docs/REFERENCIAS.md) · [Mudanças](CHANGELOG.md)

**CI confirmada:** [testes aprovados](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/runs/41227629612). Consulte o registro de [validação remota](docs/validacao-remota.json).
