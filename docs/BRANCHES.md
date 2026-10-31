# Branches e entregas

Use `main` para clonar e executar a versão consolidada. As branches abaixo preservam o ponto de entrega de cada assunto; depois da integração, podem estar atrás de `main`.

Cada branch está ligada a uma alteração concreta. A organização foi feita nesta edição: os nomes não indicam trabalho em datas antigas nem revisão de outras pessoas.

| Branch | Finalidade | Acesso |
| --- | --- | --- |
| `main` | Código e documentação consolidados | [Abrir](https://github.com/luigiscofano/usp-mac0122-algoritmos/tree/main) |
| `docs/collatz-validado` | Registrar CI C11 aprovada e atualizar catalogo de entregas | [PR #7](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/7) |
| `docs/evidencia-da-ci` | Registrar validacao remota e artefatos reproduziveis | [PR #5](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/5) |
| `docs/objetivos-e-arquitetura` | Documentar objetivos pedagogicos, arquitetura e procedencia | [PR #4](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/4) |
| `feat/aplicacoes-e-acervo` | Adicionar uniao de intervalos e busca em A+A | [PR #2](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/2) |
| `feat/collatz-c11` | Adicionar estudo de Collatz em C11 com limites verificados | [PR #6](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/6) |
| `feat/fundamentos` | Implementar busca de genes por quadro de leitura | [PR #1](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/1) |
| `test/verificacao-automatica` | Adicionar testes executaveis e GitHub Actions | [PR #3](https://github.com/luigiscofano/usp-mac0122-algoritmos/pull/3) |
| `acervo/collatz-2022` | Publicar relatório autorizado de Collatz com leitura crítica | [Acervo](../acervo/README.md) · [Branch](https://github.com/luigiscofano/usp-mac0122-algoritmos/tree/acervo/collatz-2022) |
| `docs/genes-e-quadros` | Detalhar estudo de genes e invariantes por quadro | [Guia](../docs/topicos/GENES.md) · [Branch](https://github.com/luigiscofano/usp-mac0122-algoritmos/tree/docs/genes-e-quadros) |
| `docs/intervalos-e-pares` | Organizar guias de intervalos e contagem de pares | [Guia](../docs/topicos/INTERVALOS_E_PARES.md) · [Branch](https://github.com/luigiscofano/usp-mac0122-algoritmos/tree/docs/intervalos-e-pares) |

## Como continuar

Parta da versão atual de `main`, crie uma branch para uma mudança delimitada e abra um PR explicando comportamento, motivo e validação. Não use branches antigas como base para novos assuntos sem atualizar a base.

```sh
git switch main
git pull --ff-only
git switch -c docs/nova-atividade
```

[Guias por assunto](topicos/README.md) · [Registro de publicação](PUBLICACAO.md) · [Todos os PRs](https://github.com/luigiscofano/usp-mac0122-algoritmos/pulls?q=is%3Apr)
