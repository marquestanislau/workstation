<?php

App::uses('AppController', 'Controller');

/**
 * Ctas Controller
 *
 * @property Cta $Cta
 * @property PaginatorComponent $Paginator
 */
class CtasController extends AppController {

    /**
     * Components
     *
     * @var array
     */
    public $components = array('Paginator', 'Flash');

    /**
     * index method
     *
     * @return void
     */
    public function index() {
        $this->Cta->recursive = 0;
        $this->set('ctas', $this->Paginator->paginate());
    }

    /**
     * view method
     *
     * @throws NotFoundException
     * @param string $id
     * @return void
     */
    public function view($id = null) {
        if (!$this->Cta->exists($id)) {
            throw new NotFoundException(__('Invalid cta'));
        }
        $options = array('conditions' => array('Cta.' . $this->Cta->primaryKey => $id));
        $this->set('cta', $this->Cta->find('first', $options));
    }

    /**
     * add method
     *
     * @return void
     */
    public function add() {
        if ($this->request->is('post')) {
            $this->Cta->create();
            $this->Cta->Funcionario->create();
            if ($this->Cta->saveAssociated($this->request->data)) {
                $this->Flash->success(__('The cta has been saved.'));
                return $this->redirect(array('action' => 'index'));
            } else {
                $this->Flash->error(__('The cta could not be saved. Please, try again.'));
            }
        }
        $funcionarios = $this->Cta->Funcionario->find('list');
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
        if (!$this->Cta->exists($id)) {
            throw new NotFoundException(__('Invalid cta'));
        }
        if ($this->request->is(array('post', 'put'))) {
            if ($this->Cta->saveAssociated($this->request->data)) {
                $this->Flash->success(__('The cta has been saved.'));
                return $this->redirect(array('action' => 'index'));
            } else {
                $this->Flash->error(__('The cta could not be saved. Please, try again.'));
            }
        } else {
            $options = array('conditions' => array('Cta.' . $this->Cta->primaryKey => $id));
            $this->request->data = $this->Cta->find('first', $options);
        }
        $funcionarios = $this->Cta->Funcionario->find('list');
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
        $this->Cta->id = $id;
        if (!$this->Cta->exists()) {
            throw new NotFoundException(__('Invalid cta'));
        }
        $this->request->allowMethod('post', 'delete');
        if ($this->Cta->delete()) {
            $this->Flash->success(__('The cta has been deleted.'));
        } else {
            $this->Flash->error(__('The cta could not be deleted. Please, try again.'));
        }
        return $this->redirect(array('action' => 'index'));
    }

}
