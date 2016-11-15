<?php

App::uses('AppController', 'Controller');

/**
 * Cds Controller
 *
 * @property Cd $Cd
 * @property PaginatorComponent $Paginator
 * @property SessionComponent $Session
 * @property FlashComponent $Flash
 */
class CdsController extends AppController {

    /**
     * Components
     *
     * @var array
     */
    public $components = array('Paginator', 'Session', 'Flash');

    /**
     * index method
     *
     * @return void
     */
    public function index() {
        $this->Cd->recursive = 0;
        $this->set('cds', $this->Paginator->paginate());
    }

    /**
     * view method
     *
     * @throws NotFoundException
     * @param string $id
     * @return void
     */
    public function view($id = null) {
        if (!$this->Cd->exists($id)) {
            throw new NotFoundException(__('Invalid cd'));
        }
        $options = array('conditions' => array('Cd.' . $this->Cd->primaryKey => $id));
        $this->set('cd', $this->Cd->find('first', $options));
    }

    /**
     * add method
     *
     * @return void
     */
    public function add() {
        if ($this->request->is('post')) {
            $this->Cd->create();
            if ($this->Cd->saveAssociated($this->request->data)) {
                $this->Flash->success(__('The cd has been saved.'));
                return $this->redirect(array('action' => 'index'));
            } else {
                $this->Flash->error(__('The cd could not be saved. Please, try again.'));
            }
        }
        $funcionarios = $this->Cd->Funcionario->find('list');
        $this->set(compact('funcionarios'));
    }

    /**
     * edit method
     *
     * @throws NotFoundException
     * @param string $id
     * @return void
     */
    public function edit($id = null) {
        if (!$this->Cd->exists($id)) {
            throw new NotFoundException(__('Invalid cd'));
        }
        if ($this->request->is(array('post', 'put'))) {
            if ($this->Cd->save($this->request->data)) {
                $this->Flash->success(__('The cd has been saved.'));
                return $this->redirect(array('action' => 'index'));
            } else {
                $this->Flash->error(__('The cd could not be saved. Please, try again.'));
            }
        } else {
            $options = array('conditions' => array('Cd.' . $this->Cd->primaryKey => $id));
            $this->request->data = $this->Cd->find('first', $options);
        }
        $funcionarios = $this->Cd->Funcionario->find('list');
        $this->set(compact('funcionarios'));
    }

    /**
     * delete method
     *
     * @throws NotFoundException
     * @param string $id
     * @return void
     */
    public function delete($id = null) {
        $this->Cd->id = $id;
        if (!$this->Cd->exists()) {
            throw new NotFoundException(__('Invalid cd'));
        }
        $this->request->allowMethod('post', 'delete');
        if ($this->Cd->delete()) {
            $this->Flash->success(__('The cd has been deleted.'));
        } else {
            $this->Flash->error(__('The cd could not be deleted. Please, try again.'));
        }
        return $this->redirect(array('action' => 'index'));
    }

}
