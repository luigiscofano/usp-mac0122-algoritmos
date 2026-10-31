# Experimentos e critérios de aceitação

## Exercício guiado

Execute os exemplos de [INSTALACAO.md](INSTALACAO.md) e anote a previsão antes de rodar. A saída só conta como evidência depois de comparada com o contrato de [ARQUITETURA.md](ARQUITETURA.md).

## Casos de fronteira e referência

5.000 DNAs e 5.000 vetores com duplicatas confrontados com oráculos; 500 uniões comparadas com cobertura de segmentos inteiros. Casos adicionais: stops, sobreposições, vazio, extremos de int, NaN e entradas inválidas.

Leia a suíte e escolha um caso que quebra uma solução ingênua. Explique o motivo, reduza a entrada ao menor contraexemplo e proponha uma correção sem alterar o contrato silenciosamente. Use referência independente quando disponível.

## O que não concluir

Sem autenticação dos fontes antigos ou execução no corretor de 2023; sem Interval1D/StdDraw; união em double sem geometria exata; tempos não usados como critério de aprovação.

Não use tempo isolado ou gráfico atraente como prova de correção. Registre ambiente, entrada, saída, versão e limitações relevantes.
