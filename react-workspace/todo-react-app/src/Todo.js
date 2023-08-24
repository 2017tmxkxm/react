import { Checkbox, InputBase, ListItem, ListItemText, ListItemSecondaryAction, IconButton } from "@mui/material";
import { DeleteOutlined } from "@mui/icons-material";
import React, { useState } from "react";

const Todo = (props) => {
    const [item, setItem] = useState(props.item);
    const [readOnly, setReadOnly] =useState(true);
    const editItem = props.editItem;
    const deleteItem = props.deleteItem;

    // checkbox 업데이트
    const checkboxEventHandler = (e) => {
        item.done = e.target.checked;
        editItem(item);
    }

    // item 수정 함수
    const editEventHandler = (e) => {
        setItem({...item, title:e.target.value});
    }

    // trunOnReadOnly > enterKeyEventHandler 함수
    const trunOnReadOnly = (e) => {
        if(e.key === 'Enter' && readOnly === false) {
            setReadOnly(true);
            editItem(item);
        }
    } 

    // turnOffReadOnly 함수 작성
    const turnOffReadOnly = () => {
        setReadOnly(false);
    }

    // deleteEventHandler 작성
    const deleteEventHandler = () => {
        deleteItem(item);
    }

    return (
       <ListItem>
            <Checkbox checked={item.done} onChange={checkboxEventHandler}/>
            <ListItemText>
                <InputBase 
                    inputProps={{ 
                        "aria-label": "naked",
                        readOnly : readOnly}}
                    onClick={turnOffReadOnly}
                    onKeyDown={trunOnReadOnly}
                    onChange={editEventHandler}
                    type="text"
                    id={item.id}
                    name={item.id}
                    value={item.title}
                    multiline={true}
                    fullWidth={true}
                />    
            </ListItemText>    
            <ListItemSecondaryAction>
                <IconButton aria-label="Delete Todo"
                            onClick={deleteEventHandler}>
                    <DeleteOutlined />
                </IconButton>
            </ListItemSecondaryAction>
       </ListItem>
    )
}

export default Todo;