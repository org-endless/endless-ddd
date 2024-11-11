function setValue(obj, keys, value) {
    const key = keys.shift(); // 获取当前键

    // 检查是否是数组格式
    const arrayMatch = key.match(/^(\w+)\[(\d+)\]$/);
    if (arrayMatch) {
        const arrayName = arrayMatch[1]; // 数组名
        const arrayIndex = parseInt(arrayMatch[2], 10); // 数组索引

        obj[arrayName] = obj[arrayName] || [];
        obj[arrayName][arrayIndex] = obj[arrayName][arrayIndex] || {};

        // 继续递归调用，如果还有更多的键
        if (keys.length > 0) {

            setValue(obj[arrayName][arrayIndex], keys, handleValue(value));
        } else {
            obj[arrayName][arrayIndex] = handleValue(value); // 最后一个键，赋值
        }
    } else {
        // 如果没有数组，直接赋值或者继续递归
        obj[key] = obj[key] || {};
        if (keys.length > 0) {
            setValue(obj[key], keys, handleValue(value)); // 继续递归
        } else {
            obj[key] = handleValue(value); // 最后一个键，赋值
        }
    }
}
function handleValue(value){
    if(value === 'on') return true
    if(value === 'false') return false
    return value
}