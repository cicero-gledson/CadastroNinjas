# Padronização de Commits (Conventional Commits)

Este guia define os tipos e escopos utilizados para organizar o histórico de alterações do projeto.

---

## 🛠 Tipos (Types)
Os tipos indicam a natureza da mudança realizada.

* **`feat` (Feature / Funcionalidade):** Commits que adicionam ou removem uma nova funcionalidade.
* **`fix` (Fix / Correção):** Commits que corrigem um erro (*bug*).
* **`refactor` (Refactor / Refatoração):** Commits que reescrevem ou reestruturam o código, mas **não** alteram o comportamento da API.
* **`perf` (Performance / Desempenho):** Refatorações especiais que melhoram o desempenho (*performance*).
* **`style` (Style / Estilo):** Alterações que não afetam o sentido do código (espaços, formatação, ponto e vírgula, etc.).
* **`test` (Test / Teste):** Adição de testes ausentes ou correção de testes existentes.
* **`docs` (Documentation / Documentação):** Alterações exclusivas na documentação.
* **`build` (Build / Construção):** Alterações em ferramentas de *build*, *pipeline* de CI, dependências ou versão.
* **`ops` (Operations / Operações):** Alterações em infraestrutura, *deployment* (implantação), backup ou recuperação.
* **`chore` (Chore / Tarefa rotineira):** Commits diversos que não afetam a produção (ex: modificar `.gitignore`).

---

## 🎯 Escopos (Scopes)
O escopo fornece contexto adicional sobre onde a mudança ocorreu.

* **Opcional:** É uma parte opcional do formato.
* **Específico:** Os escopos permitidos dependem do projeto.
* **Sem Identificadores:** Não use IDs de *issues* (problemas/tarefas) como escopo.

---

> **Dica para Memorizar:**
> * **Mudança para o Usuário:** `feat`, `fix`.
> * **Qualidade do Código:** `refactor`, `perf`, `style`, `test`.
> * **Processos e Documentos:** `docs`, `build`, `ops`, `chore`.