import React from 'react'

function Food() {
    const food1="pizza";
    const food2="burger";
    return (
        <div>
            <li>Apple</li>
            <li>{food1.toUpperCase()}</li>
            <li>{food2}</li>
        </div>
    )
}

export default Food
