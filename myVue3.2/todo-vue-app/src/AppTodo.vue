<template>
  <div>
    <TodoInput @addItem="addItemHandler" />
    <TodoList :todolist="todolist" @update-todo="updateTodo" @delete-todo="deleteTodo" />
  </div>
</template>

<script>
import TodoInput from "./components/TodoInput.vue";
import TodoList from "./components/TodoList.vue";

export default {
  name: "AppTodo",
  components: { TodoInput, TodoList },
  data() {
    return {
      todo: "",
      todolist: [
        { id: 1, todo: "내용1", completed: false },
        { id: 2, todo: "내용2", completed: true },
        { id: 3, todo: "내용3", completed: false },
      ],
    };
  },
  methods: {
    addItemHandler(e) {
      const ids = this.todolist.map(todo=> {return todo.id})
      const maxId = ids.length == 0? 0 : Math.max(...ids)
      this.todolist.push({
        id: maxId + 1,
        todo: e.todo,
        completed: false,
      });
    },
    updateTodo(updatedItem) {
      const index = this.todolist.findIndex((todo) => todo.id === updatedItem.id);
      this.todolist[index].completed = !this.todolist[index].completed;
    },
    deleteTodo(index) {
      this.todolist.splice(index, 1);
    },
  },
};
</script>

<style scoped>
@import "https://unpkg.com/bootstrap@5.2.3/dist/css/bootstrap.min.css";
body {
      margin: 0;
      padding: 0;
      font-family: sans-serif;
    }
</style>
