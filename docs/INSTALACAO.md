# Instalação e reprodução

Ambiente: **Java 17+ e Python 3.12**. Execute a partir da raiz. Use python ou python3 conforme seu sistema.

```sh
python scripts/verificar.py
java -cp build/classes FindGene < examples/dna.txt
java -cp build/classes UnionOfIntervals -v examples/intervalos.txt
java -cp build/classes BuscaEmAA 4 1 1 3 3
```

Artefatos gerados ficam em build/, ignorado pelo Git. O script deve encerrar com zero em sucesso. Em falha, confira versão, PATH, diretório corrente e fixture antes de alterar o contrato. Os scripts não contêm caminhos do computador do autor.

Consulte [ARQUITETURA.md](ARQUITETURA.md) para entradas e limites e [VALIDACAO.md](VALIDACAO.md) para a evidência efetiva.

## Collatz em C11

Requer compilador C11 (CC para indicar outro executável):

```sh
python scripts/verificar_collatz.py
./build/collatz 1 10
```

No Windows, use build\collatz.exe. O módulo C foi testado localmente e tem job específico em Ubuntu; não se afirma teste remoto de C nas outras plataformas.
