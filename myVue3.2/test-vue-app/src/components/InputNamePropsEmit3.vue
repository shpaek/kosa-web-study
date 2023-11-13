<template>
    <div>
        검색어를 입력하세요:
        <input type="text"
               v-bind:value="word"
               @input="$event => $emit('update:word', $event.target.value)"
               />
    </div>
</template>
<script>
export default{
    name: "InputNamePropsEmit3",
    props: ["word"]
}
</script>