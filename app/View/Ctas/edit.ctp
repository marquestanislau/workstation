<div class="col-md-8">
    <?php echo $this->Form->create('Cta'); ?>
    <fieldset>
        <legend><?php echo __('Edit Cta'); ?></legend>
        <?php
        echo $this->Form->input('id');
        echo $this->Form->input('funcionario_id', array('type' => 'hidden'));
        echo $this->Form->input('Funcionario.nome');
        echo $this->Form->input('Funcionario.apelido');
        echo $this->Form->input('Funcionario.contacto_alternativo');
        echo $this->Form->input('Funcionario.contacto_pessoal');
        echo $this->Form->input('Funcionario.data_nascimento');
        echo $this->Form->input('Funcionario.sexo');
        ?>
    </fieldset>
    <?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="col-md-4>
    <h3><?php echo __('Actions'); ?></h3>
    <ul>

        <li><?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $this->Form->value('Cta.id')), array('confirm' => __('Are you sure you want to delete # %s?', $this->Form->value('Cta.id')))); ?></li>
        <li><?php echo $this->Html->link(__('List Ctas'), array('action' => 'index')); ?></li>
        <li><?php echo $this->Html->link(__('List Funcionarios'), array('controller' => 'funcionarios', 'action' => 'index')); ?> </li>
        <li><?php echo $this->Html->link(__('New Funcionario'), array('controller' => 'funcionarios', 'action' => 'add')); ?> </li>
    </ul>
</div>
