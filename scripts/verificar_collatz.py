"""Compila C11 e compara casos conhecidos e erros de fronteira."""

from pathlib import Path
import csv
import io
import os
import subprocess

root = Path(__file__).resolve().parents[1]
os.chdir(root)
Path("build").mkdir(exist_ok=True)
programa = root / "build" / ("collatz.exe" if os.name == "nt" else "collatz")
subprocess.run(
    [
        os.environ.get("CC", "cc"),
        "-std=c11",
        "-Wall",
        "-Wextra",
        "-Werror",
        "-pedantic",
        "-O2",
        "src/collatz/collatz.c",
        "-o",
        str(programa),
    ],
    check=True,
)


def rodar(*args):
    return subprocess.run(
        [str(programa), *map(str, args)], capture_output=True, text=True, timeout=10
    )


for n, passos, pico in [(1, 0, 1), (2, 1, 2), (6, 8, 16), (27, 111, 9232)]:
    resultado = rodar(n, n)
    assert resultado.returncode == 0, resultado.stderr
    linha = list(csv.DictReader(io.StringIO(resultado.stdout)))[0]
    assert linha == {
        "n": str(n),
        "passos": str(passos),
        "pico": str(pico),
        "estado": "concluiu",
    }, linha
assert rodar(27, 27, 100).returncode == 2
assert "limite" in rodar(27, 27, 100).stdout
assert "overflow" in rodar(2**64 - 1, 2**64 - 1).stdout
assert rodar(2**64 - 1, 2**64 - 1).returncode == 2
for args in [(0, 1), (-1, 1), (2, 1), (1, 10001), (1, 1, 1000001), (2**64, 2**64)]:
    assert rodar(*args).returncode == 1, args
assert [int(r["n"]) for r in csv.DictReader(io.StringIO(rodar(1, 6).stdout))] == list(
    range(1, 7)
)
print(
    "PASS: Collatz C11, casos conhecidos, intervalo, limite, overflow e entradas invalidas"
)
