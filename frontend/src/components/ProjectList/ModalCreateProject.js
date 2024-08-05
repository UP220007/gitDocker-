import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { useState } from 'react';
import { TextField } from '@mui/material';
import { MenuItem } from '@mui/material';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

const ModalCreateProject = ({open, handleClose, users , handleCreate}) => {

    const user=JSON.parse(localStorage.getItem("user"))

    const [values, setValues] = useState({
        name: '',
        description: '',
        dateAdd:'',
        userId:''
      });

      const handleChange = (event) => {
        const { name, value } = event.target;
        setValues(prevFormData => ({
          ...prevFormData,
          [name]: value
        }));
      };

      const handleSubmit = () => {
        values.dateAdd=new Date().toISOString()
        values.userId =user.id
        handleCreate(values);
        setValues({
            name: '',
            description: '',
            dateAdd: '',
            userId: ''
        });
        handleClose();
    };

    return (
        <Modal
            open={open}
            onClose={handleClose}
            aria-labelledby="modal-title"
            aria-describedby="modal-description"
        >
            <Box sx={style}
                component="form"
                >
                <Typography id="modal-modal-title" variant="h6" component="h2">
                    Crear Proyecto
                </Typography>
                <Typography id="modal-modal-description" 
                    sx={{ 
                        display: { xs: 'none', md: 'flex' },
                        mt: 2, 
                        gap:"30px", 
                        flexDirection:"column"    
                    }}
                >
                    <TextField 
                        id="project_name" 
                        name='name'
                        value={values.name}
                        onChange={handleChange}
                        label="Nombre del proyecto" 
                        variant="standard" 
                        sx={{width:"100%"}}
                    />
                    <TextField 
                        id="project_description"
                        name='description'
                        value={values.description}
                        onChange={handleChange} 
                        label="Descripción" 
                        variant="standard" 
                        multiline 
                        sx={{width:"100%"}}
                    />
                    <TextField
                        id="project_user"
                        name='userId'
                        value={values.userId}
                        onChange={handleChange}
                        select
                        label="Responsable"
                        variant="standard"    
                    >
                        {users?.map((user)=>(
                            <MenuItem key={user.id} value={user.id}>
                                {user.firstName} {user.lastName}
                            </MenuItem>
                        ))}
                    </TextField>

                    <Box sx={{display:"flex", gap:"20px"}}>
                        <Button variant='contained' sx={{ mt: 2 }} onClick={handleSubmit}>
                            Crear
                        </Button>
                        <Button variant='contained' sx={{ mt: 2 }} onClick={()=>{
                                handleClose()
                                setValues({
                                    name: '',
                                    description: '',
                                    dateAdd: '',
                                    userId: ''
                                });
                                }}>
                            Cancelar
                        </Button >
                    </Box>
                </Typography>
            </Box>
        </Modal>
    );
}

export default ModalCreateProject;