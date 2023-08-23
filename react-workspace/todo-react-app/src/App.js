import './App.css';
import Todo from './Todo';
import React, { useState } from "react";
import { List, Paper } from "@mui/material";

function App() {
  const [items, setItems] = useState([
    {
      id: "0",
      title: "Hello World 1",
      doen: true
    },
    {
      id: "1",
      title: "Hello World 2",
      doen: false
    },
  ]);

  let todoItems = items.length > 0 && (
    <Paper style={{ margin: 16 }}>
      <List>
        {items.map((item) => (
          <Todo item={item} key={item.id} />
        ))}  
      </List>
    </Paper>
    );

  return (
    <div className="App">
      {todoItems}
    </div>
  );
}

export default App;
