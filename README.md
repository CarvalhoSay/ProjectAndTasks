🧠 Desafio Técnico – Sistema de Gestão de Projetos e Demandas

O sistema será utilizado por um time de desenvolvimento para organizar suas entregas, acompanhar o status das tarefas e realizar análises simples.

Models:
- Project
- Task

EndPoints: 

(/project)
- POST Criar novo projeto (name obrigatório)
- GET /projects	Listar todos os projetos

(/tasks)
- POST /tasks	Criar nova tarefa vinculada a um projeto
- GET	(/tasks?status=&priority=&projectId=)	Buscar tarefas com filtros opcionais
- PUT (	/tasks/{id}/status)	Atualizar apenas o status da tarefa
- DELETE(/tasks/{id})	Remover tarefa
