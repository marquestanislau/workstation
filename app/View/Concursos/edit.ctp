<div class="concursos form">
<?php echo $this->Form->create('Concurso'); ?>
	<fieldset>
		<legend><?php echo __('Edit Concurso'); ?></legend>
	<?php
		echo $this->Form->input('id');
		echo $this->Form->input('data_aprovacao');
		echo $this->Form->input('data_registo');
		echo $this->Form->input('nome');
	?>
	</fieldset>
<?php echo $this->Form->end(__('Submit')); ?>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>

		<li><?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $this->Form->value('Concurso.id')), array('confirm' => __('Are you sure you want to delete # %s?', $this->Form->value('Concurso.id')))); ?></li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('action' => 'index')); ?></li>
	</ul>
</div>
