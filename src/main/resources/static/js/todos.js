document.addEventListener('alpine:init', () => {
    Alpine.data('initData', () => ({
        "header": "List of Todos",
        todos: [],
        newTodo: {content: ''},

        init() {
            this.fetchTodos()
        },
        fetchTodos () {
            $.getJSON("/api/todos", (data) => {
                console.log("Todos Resp:", data)
                this.todos = data
            });
        }
    }))
});