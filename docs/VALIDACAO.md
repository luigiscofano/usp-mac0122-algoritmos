# Validação

## Evidência local — 31/10/2026

5.000 DNAs e 5.000 vetores com duplicatas confrontados com oráculos; 500 uniões comparadas com cobertura de segmentos inteiros. Casos adicionais: stops, sobreposições, vazio, extremos de int, NaN e entradas inválidas.

## Limites da conclusão

Sem autenticação dos fontes antigos ou execução no corretor de 2023; sem Interval1D/StdDraw; união em double sem geometria exata; tempos não usados como critério de aprovação.

Um workflow configurado ou PR aberto não demonstra aprovação. A evidência remota e o commit testado serão registrados após conclusão do GitHub Actions.

O [registro local estruturado](validacao-local.json) preserva o comando e o log efetivamente obtidos.

## Evidência remota confirmada

[Execução 41227629612](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/runs/41227629612) aprovada no commit `47d153d6e0b8258c5e57690b5b5113c2a2902c54`.

- **testes (windows-latest)**: success.
- **testes (macos-15)**: success.
- **testes (ubuntu-24.04)**: success.

Os artefatos podem exigir login no GitHub e têm prazo de retenção; os fontes permanecem no repositório.

- [evidencia-ubuntu-24.04](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/runs/41227629612/artifacts/13052585587) — retenção até 2027-01-29T18:04:56Z.
- [evidencia-macos-15](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/runs/41227629612/artifacts/13052346767) — retenção até 2027-01-29T18:04:56Z.
- [evidencia-windows-latest](https://github.com/luigiscofano/usp-mac0122-algoritmos/actions/runs/41227629612/artifacts/13051474713) — retenção até 2027-01-29T18:04:56Z.

O commit acima identifica exatamente a versão testada. Atualizações documentais posteriores não ampliam a conclusão funcional.

## Extensão Collatz em C11

Teste local aprovado com compilação estrita (-Wall -Wextra -Werror -pedantic), casos conhecidos 1/2/6/27, intervalo, orçamento, overflow uint64 e entradas inválidas. Para 27 foram verificados 111 passos e pico 9232. A nova configuração inclui job C11 em Ubuntu. O registro remoto acima corresponde à suíte Java anterior à extensão; o badge e o histórico do Actions mostram a execução adicional.
