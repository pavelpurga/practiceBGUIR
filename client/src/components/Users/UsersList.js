import React, {Component} from 'react';
import {Link} from "react-router-dom";
import {Button, ButtonGroup, Container, Table} from "reactstrap";
import Header from "../header/header";
class UsersList extends Component {
    constructor(props) {
        super(props);
        this.state = {users:[]};
        this.remove = this.remove.bind(this);
    }
    componentDidMount(){
        fetch('/users')
            .then(response => response.json())
            .then(data => this.setState({users: data}));
    }
    async remove(id) {
        await fetch(`/users/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedUsers = [...this.state.users].filter(i => i.id !== id);
            this.setState({users: updatedUsers});
        });
    }

    render() {
        const {users} = this.state;
        const usersList = users.map(user => {
            return <tr key={user.id}>
                <td style={{whiteSpace: 'nowrap'}}>{user.name}</td>
                <td>{user.age}</td>
                <td>{user.email}</td>
                <td>{user.role}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/users/" + user.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(user.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/products/new">Add User</Button>
                    </div>
                    <h3>Users</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Age</th>
                            <th width="40%">Email</th>
                            <th width="30%">Role</th>
                        </tr>
                        </thead>
                        <tbody>
                        {usersList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default UsersList;