document.addEventListener('alpine:init', () => {
    Alpine.data('initData', (todoId) => ({
        "header": "View Todo",
        id: todoId,
        todo: {},
        init() {
            this.fetchTodo(this.id)
        },
        fetchTodo (id) {
            $.getJSON("/api/todos/"+id, (data) => {
                this.todo = data
            });
        },
        updateTodo() {
            $.ajax ({
                url: '/api/todos/'+this.todo.id,
                type: "PUT",
                dataType: "json",
                contentType: "application/json",
                data : JSON.stringify(this.todo),
                complete: () => {
                    window.location = "/";
                }
            });
        },
        deleteTodo() {
            $.ajax ({
                url: '/api/todos/'+this.todo.id,
                type: "DELETE",
                complete: () => {
                    window.location = "/";
                }
            });
        },
    }))
});