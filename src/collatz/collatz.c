/* Implementação nova de estudo; não é o fonte da entrega histórica. */
#include <errno.h>
#include <inttypes.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum { CONCLUIU, LIMITE, OVERFLOW } Estado;

typedef struct {
  uint64_t passos;
  uint64_t pico;
  Estado estado;
} Resultado;

static Resultado calcular(uint64_t numero, uint64_t limite) {
  Resultado resultado = {0, numero, CONCLUIU};
  while (numero != 1) {
    if (resultado.passos == limite) {
      resultado.estado = LIMITE;
      return resultado;
    }
    if (numero % 2 == 0) {
      numero /= 2;
    } else {
      /* Checa antes de calcular, evitando overflow silencioso de 3n+1. */
      if (numero > (UINT64_MAX - 1) / 3) {
        resultado.estado = OVERFLOW;
        return resultado;
      }
      numero = 3 * numero + 1;
    }
    resultado.passos++;
    if (numero > resultado.pico) resultado.pico = numero;
  }
  return resultado;
}

static int ler_numero(const char *texto, uint64_t *valor) {
  if (*texto == '\0' || strspn(texto, "0123456789") != strlen(texto)) return 0;
  errno = 0;
  char *fim;
  uintmax_t numero = strtoumax(texto, &fim, 10);
  if (errno == ERANGE || *fim != '\0' || numero > UINT64_MAX) return 0;
  *valor = (uint64_t)numero;
  return 1;
}

int main(int argc, char **argv) {
  uint64_t inicio, fim, limite = 10000;
  if ((argc != 3 && argc != 4) || !ler_numero(argv[1], &inicio) ||
      !ler_numero(argv[2], &fim) || (argc == 4 && !ler_numero(argv[3], &limite)) ||
      inicio == 0 || inicio > fim || fim - inicio >= 10000 || limite > 1000000) {
    fprintf(stderr, "Uso: collatz inicio fim [limite_passos]\n"
                    "1 <= inicio <= fim; ate 10000 valores; limite <= 1000000\n");
    return 1;
  }
  int falhou = 0;
  puts("n,passos,pico,estado");
  for (uint64_t n = inicio;; n++) {
    Resultado r = calcular(n, limite);
    const char *estado = r.estado == CONCLUIU ? "concluiu" :
                         r.estado == LIMITE ? "limite" : "overflow";
    printf("%" PRIu64 ",%" PRIu64 ",%" PRIu64 ",%s\n",
           n, r.passos, r.pico, estado);
    if (r.estado != CONCLUIU) falhou = 2;
    /* Evita incrementar UINT64_MAX depois do último elemento. */
    if (n == fim) break;
  }
  return falhou;
}
