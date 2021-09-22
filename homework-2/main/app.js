function addTokens(input, tokens){
    if(typeof input=="string"){
        if(input.length>=6){
            tokens.forEach(token =>{
                if (typeof token.tokenName !== "string")
                    throw TypeError("Invalid array format");
            })
            tokens.forEach(token=>{
                input = input.replace("...", "${" + token.tokenName+"}");
            })
            return input;
        }else
        throw Error(`Input should have at least 6 characters`);
    }else 
    throw TypeError(`Invalid input`);
}



const app = {
    addTokens: addTokens
}

module.exports = app;