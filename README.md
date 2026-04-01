# Registro da Guilda de Aventureiros - TP2

Projeto desenvolvido com Spring Boot contendo:

## Funcionalidades

- Integração com banco legado (schema audit)
- Mapeamento JPA com relacionamentos complexos
- Domínio de Aventureiros e Missões (schema aventura)
- Consultas operacionais com filtros
- Relatórios agregados (ranking e métricas)
- Testes automatizados

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Como executar

1. Subir banco via Docker:
docker pull leogloriainfnet/postgres-tp2-spring:1.0

2. Rodar aplicação Spring Boot

3. Executar testes

## Estrutura

- audit → domínio legado
- aventura → novo domínio de negócio

---

Projeto desenvolvido como parte do TP2 da disciplina de Desenvolvimento de Serviços com Spring Boot.